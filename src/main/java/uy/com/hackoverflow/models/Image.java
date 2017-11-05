package uy.com.hackoverflow.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by emiliano on  04/11/17.
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String URL;

    public Image() {
    }

    public Image(String URL) {
        this.URL = URL;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Long getId() {
        return id;
    }
}
