package hello.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestSomething {

    @Test
    @DisplayName("Spring의 우선순의 전략을 확인한다.")
    void checkOrder(){
        RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();

        //초기값은 다 맥스
        int requestMappingHandlerMappingOrder = requestMappingHandlerMapping.getOrder();
        System.out.println("requestMappingHandlerMappingOrder = " + requestMappingHandlerMappingOrder);

        BeanNameUrlHandlerMapping beanNameUrlHandlerMapping = new BeanNameUrlHandlerMapping();
        int beanNameUrlHandlerMappingOrder = beanNameUrlHandlerMapping.getOrder();
        System.out.println("beanNameUrlHandlerMappingOrder = " + beanNameUrlHandlerMappingOrder);

    }

    @Test
    @DisplayName("map entry set?")
    void showMeMapEntrySet(){
        Map<Integer, someDto> map = new LinkedHashMap<>();
        map.put(5, new someDto(1,"one"));
        map.put(1, new someDto(5,"five"));
        map.put(3, new someDto(3,"three"));
        map.put(2, new someDto(4,"four"));
        map.put(4, new someDto(2,"two"));

        System.out.println(map.entrySet());

        List<Map.Entry<Integer, someDto>> toSort = new ArrayList<>();
        for (Map.Entry<Integer, someDto> integersomeDtoEntry : map.entrySet()) {
            toSort.add(integersomeDtoEntry);
        }
        toSort.sort(Map.Entry.comparingByKey());
        LinkedHashMap<Integer, someDto> collect = new LinkedHashMap<>();
        for (Map.Entry<Integer, someDto> integersomeDtoEntry : toSort) {
            collect.putIfAbsent(integersomeDtoEntry.getKey(), integersomeDtoEntry.getValue());
        }

        System.out.println("collect = " + collect.entrySet());

    }
}
