package hello.test;


public class someDto {
    private int order;
    private String name;

    public someDto() {
    }

    public someDto(int order, String name) {
        this.order = order;
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
