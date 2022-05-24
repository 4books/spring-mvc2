package hello.itemservice.domain.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class updateParamDTO {

    private String itemName;
    private Integer price;
    private Integer quantity;

    public updateParamDTO() {
    }

    public updateParamDTO(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
