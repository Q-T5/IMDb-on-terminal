package npc.martin.imdbonterminal.views;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

//the JSON respose is a (self-named) MoviesResultObject
public class MoviesResultObject {
    //this object has a collection of movie matches- which we call MovieMatchObject
    private List<MovieMatches> d = null;

    //and these are the other instance variables of this class
    private String q; //your search querry

    public String getSearchQuerry() {
        return q;
    }

    public List<MovieMatches> getMovieMatches() {
        return d;
    }

    @Override
    public String toString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(this);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

//this is the class representing a single match result- a movie match
class MovieMatches {
    //It has an image object- which we refer to by the MoviePoster class
    //the URL here is a default image that will be downloaded if the resulting JSON object has no
    //URL to it's own image
    private MoviePoster i = new MoviePoster("https://drukasia.com/images/stripes/umaparo.jpg");

    //and these are other instance variables of interest that a single match 'may' have
    private String l = "Not Available"; //movie label (name) on IMDb servers
    private Integer rank = 0000; //movie rank on IMDb
    private String s = "Not Available"; //movie starrings
    private Integer y = 0000; //year the movie will be released

    public MoviePoster getMoviePoster() {
        return i;
    }
    
    public String getMovieLabel() {
        return l;
    }
    
    public String getMovieStarrings() {
        return s;
    }
    
    
    public Integer getIMDbMovieRank() {
        return rank;
    }
    
    public Integer getYearOfRelease() {
        return y;
    }
    
    @Override
    public String toString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(this);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

//this is the class representing the MoviePoster embedded inside a single movie match
class MoviePoster {
    //these are the variables making up the image
    private String imageUrl; //URL to view the image

    public String getImageUrl() {
        return imageUrl;
    }
    
    public MoviePoster () {
        //default constructor
    }
    
    public MoviePoster (String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(this);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}