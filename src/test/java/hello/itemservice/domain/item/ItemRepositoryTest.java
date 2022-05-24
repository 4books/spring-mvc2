package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void save(){
        //given
        Item item = new Item("itemA", 10000, 10);

        //when
        Item savedItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(savedItem.getId());
        assertThat(findItem).isEqualTo(savedItem);
    }

    @Test
    void findAll(){
        //given
        Item item1 = new Item("itemA", 10000, 10);
        Item item2 = new Item("itemB", 20000, 20);

        //when
        List<Item> saveItems = new ArrayList<>();

        saveItems.add(itemRepository.save(item1));
        saveItems.add(itemRepository.save(item2));

        //then
        List<Item> findItems = itemRepository.findAll();
        assertThat(findItems.size()).isEqualTo(2);
        assertThat(findItems).contains(item1, item2);
        assertThat(saveItems).isEqualTo(findItems);
    }

    @Test
    void updateItem(){
        //given
        Item item = new Item("itemA", 10000, 10);
        Item saveItem = itemRepository.save(item);
        Long id = saveItem.getId();

        //when
        updateParamDTO dto = new updateParamDTO("itemB", 30000, 30);
        itemRepository.update(id, dto);

        //then
        Item findItem = itemRepository.findById(id);
        assertThat(dto.getItemName()).isEqualTo(findItem.getItemName());
        assertThat(dto.getPrice()).isEqualTo(findItem.getPrice());
        assertThat(dto.getQuantity()).isEqualTo(findItem.getQuantity());

    }

    @Test
    void deleteItem(){
        //given
        Item item = new Item("itemA", 10000, 10);
        Item saveItem = itemRepository.save(item);
        Long id = saveItem.getId();

        //when
        itemRepository.delete(id);
        List<Item> findAll = itemRepository.findAll();

        //then
        assertThat(findAll.size()).isEqualTo(0);
        assertThat(itemRepository.findById(id)).isNull();
//        assertThrows(NullPointerException.class, () -> {
//            itemRepository.findById(id);
//        });

    }


}