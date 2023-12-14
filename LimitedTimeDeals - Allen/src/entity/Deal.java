package entity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;

public class Deal {
    private long id;
    private HashSet<Item> items;
    private HashMap<User, Item> itemSold;
    private int dealPrice;
    private LocalDateTime endTime;
    private boolean isActive;
    private User createBy;
    private static long count = 0;

    public Deal(HashSet<Item> items, int dealPrice, LocalDateTime endTime, User createBy) {
        this.id = ++count;
        this.items = items;
        this.itemSold = new HashMap<>();
        this.dealPrice = dealPrice;
        this.endTime = endTime;
        this.isActive = true;
        this.createBy = createBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HashSet<Item> getItems() {
        return items;
    }

    public void setItems(HashSet<Item> items) {
        this.items = items;
    }

    public HashMap<User, Item> getItemSold() {
        return itemSold;
    }

    public void setItemSold(HashMap<User, Item> itemSold) {
        this.itemSold = itemSold;
    }

    public int getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(int dealPrice) {
        this.dealPrice = dealPrice;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public User getCreateBy() {
        return createBy;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", items=" + items +
                ", itemSold=" + itemSold +
                ", dealPrice=" + dealPrice +
                ", endTime=" + endTime +
                ", isActive=" + isActive +
                '}';
    }
}
