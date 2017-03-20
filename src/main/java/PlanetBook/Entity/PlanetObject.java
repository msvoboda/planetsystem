package PlanetBook.Entity;


import javax.persistence.Column;
import java.util.ArrayList;

/**
 * Created by MICHAL on 12.3.2017.
 */
public abstract class PlanetObject {
    @Column(name = "likes")
    private int Likes;

    public int getLikes()
    {
        return Likes;
    }

    public void setLikes(int set)
    {
        Likes = set;
    }
}
