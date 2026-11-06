package cl.backend.javaSpring.pedido.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.backend.javaSpring.pedido.dto.CrearPedidoRequestDTO;
import cl.backend.javaSpring.pedido.dto.ItemPedidoRequestDTO;
import cl.backend.javaSpring.pedido.dto.PedidoResponseDTO;
import cl.backend.javaSpring.pedido.mapper.PedidoMapper;
import cl.backend.javaSpring.pedido.model.DetallePedidoModel;
import cl.backend.javaSpring.pedido.model.EstadoPedidoEnum;
import cl.backend.javaSpring.pedido.model.PedidosModel;
import cl.backend.javaSpring.pedido.repository.DetallePedidoRepository;
import cl.backend.javaSpring.pedido.repository.PedidosRepository;
import cl.backend.javaSpring.producto.model.ProductosModel;
import cl.backend.javaSpring.producto.repository.ProductosRepository;
import cl.backend.javaSpring.usuario.model.UsuariosModel;
import cl.backend.javaSpring.usuario.repository.UsuarioRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor 
public class PedidoService {

    private final PedidosRepository pedidosRepository;
    private final DetallePedidoRepository detallePedidoRepository;
    private final ProductosRepository productosRepository;
    private final UsuarioRepository usuarioRepository;
    private final PedidoMapper pedidoMapper;

    @Transactional
    public PedidoResponseDTO crearPedido(CrearPedidoRequestDTO dto) {
        UsuariosModel usuario = usuarioRepository.findById(dto.getUsuarioId()).orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + dto.getUsuarioId()));
        PedidosModel pedido = pedidoMapper.toEntity(dto, usuario);
        pedido = pedidosRepository.save(pedido);

        double totalPedido = 0.0;
        List<DetallePedidoModel> detalles = new ArrayList<>();

        for (ItemPedidoRequestDTO itemDto : dto.getItems()) {
            ProductosModel producto = productosRepository.findById(itemDto.getProductoId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + itemDto.getProductoId()));
            if (producto.getStock() < itemDto.getCantidad()) {
                throw new RuntimeException("Stock insuficiente para: " + producto.getNombreProducto());
            }

            producto.setStock(producto.getStock() - itemDto.getCantidad());
            productosRepository.save(producto);
            
            DetallePedidoModel detalle = pedidoMapper.toDetailEntity(itemDto, pedido, producto);
            totalPedido += detalle.getSubtotal();
            detalles.add(detalle);
        }

        List<DetallePedidoModel> detallesGuardados = detallePedidoRepository.saveAll(detalles);
        pedido.setTotal(totalPedido);
        pedido = pedidosRepository.save(pedido);

        return pedidoMapper.toResponseDTO(pedido, detallesGuardados);
    }

    @Transactional (readOnly = true)
    public List<PedidoResponseDTO> obtenerTodos() {
        return pedidosRepository.findAll().stream()
                .map(pedido -> {
                    List<DetallePedidoModel> detalles = detallePedidoRepository.findByPedidoId(pedido.getId());
                    return pedidoMapper.toResponseDTO(pedido, detalles);
                }).toList();
    }

    @Transactional (readOnly = true)
    public List<PedidoResponseDTO> obtenerPorEstado (EstadoPedidoEnum estado) {
        return pedidosRepository.findByEstado(estado).stream().map(pedido -> {
            List<DetallePedidoModel> detalles = detallePedidoRepository.findByPedidoId(pedido.getId());
            return pedidoMapper.toResponseDTO(pedido, detalles);
        }).toList();
    }

    @Transactional
    public PedidoResponseDTO cambiarEstado(Long id, EstadoPedidoEnum nuevoEstado) {
        PedidosModel pedido = pedidosRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));
        pedido.setEstado(nuevoEstado);
        pedidosRepository.save(pedido);
        
        List<DetallePedidoModel> detalles = detallePedidoRepository.findByPedidoId(pedido.getId());
        return pedidoMapper.toResponseDTO(pedido, detalles);
    }

}
