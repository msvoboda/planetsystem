package PlanetBook.Entity;

/**
 * Created by MICHAL on 19.3.2017.
 */
public class ResultState {
    public ResultState(boolean Error, String ip, String message, int l) {
        this.Error = Error;
        this.Ip = ip;
        this.Message = message;
        this.Likes = l;
    }

    public boolean Error;
    public String Ip;
    public String Message;
    public int Likes;
}