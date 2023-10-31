package com.quind.tienda.persistence.mapper;


import com.quind.tienda.domain.model.PurchaseItem;
import com.quind.tienda.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
@Mapper(componentModel = "spring",uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto comprasProducto);
    List<PurchaseItem> toPurchaseItems(List<ComprasProducto> comprasProductos);
    @InheritInverseConfiguration
    @Mappings({@Mapping( target = "compra",ignore = true),
            @Mapping(target = "producto",ignore = true),
            @Mapping(target = "id.idCompra",ignore = true)})
    ComprasProducto toComprasProducto(PurchaseItem purchaseItem);
}
