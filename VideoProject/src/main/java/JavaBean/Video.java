package JavaBean;

import java.io.Serializable;

public class Video implements Serializable {

    private String id;
    private String name;
    private byte[] video;

    // Constructor
    public Video() {
    }

    public Video(String id, String name, byte[] video) {
        this.id = id;
        this.name = name;
        this.video = video;
    }

    // Getter and Setter for id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for video
    public byte[] getVideo() {
        return video;
    }

    public void setVideo(byte[] video) {
        this.video = video;
    }

}
