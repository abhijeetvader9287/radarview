package radarComponent;

/**
 * Created by Tushar on 08/03/17.
 */


/**
 * Created by Karam Ahkouk on 04/06/15.
 */
public class RadarPoint {
    float x;
    float y;
    int radius;

    String identifier;

    public RadarPoint(String identifier, float x, float y, int radius){
        this.identifier = identifier;
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public RadarPoint(String identifier, float x, float y){
        this.identifier = identifier;
        this.radius = radius;
        this.x = x;
        this.y = y;
    }
    public String getIdentifier()
    {
        return   this.identifier;
    }
    public float getX() {
        return this.x;
    }
    public float getY() {
        return this.y;
    }
}
