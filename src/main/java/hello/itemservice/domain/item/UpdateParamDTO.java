package hello.itemservice.domain.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateParamDTO {

    private String itemName;
    private Integer price;
    private Integer quantity;

    public UpdateParamDTO() {
    }

    public UpdateParamDTO(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
