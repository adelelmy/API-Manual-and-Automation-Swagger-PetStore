package Pojo.Update_non_existing_pet;

import Pojo.pet_valid.category_pojo;
import Pojo.pet_valid.tags_pojo;
import java.util.List;

public class update_non_existing_pet {

    private int id;
    private category_pojo category;
    private String name;
    private List<String> photoUrls;
    private List<tags_pojo> tags;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public category_pojo getCategory() {
        return category;
    }

    public void setCategory(category_pojo category) {
        this.category = category;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<tags_pojo> getTags() {
        return tags;
    }

    public void setTags(List<tags_pojo> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
