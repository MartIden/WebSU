
package beans;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "slcon")
@SessionScoped
public class SliderController {
    
    private static String name; 
    public static  ArrayList<Integer> enume = new ArrayList<>();
    public static String pathOfSlide = "resources/images/ninjaslide.jpg";
    private static final ArrayList<String> PATHES;
    private static final ArrayList<String> SPEACHES;
    private static int numberOfSlide = 0; 
    
    static {
        enume = createList();
        PATHES = createPathes();
        SPEACHES = createSpeaches();
        name = inputSpeach() ;
    }

    public static ArrayList<Integer> createList() {
        ArrayList<Integer> list = new ArrayList<>(8);
        for (int i = 0; i< 8 ; i++) {
            list.add(i);
        }
        return list;
    }
    public void setNumberOfSlide (int i) {       
       SliderController.numberOfSlide = i;
        changePathOfSlide();
        name = inputSpeach();
    }  
    public  String getPathOfSlide() {       
        return pathOfSlide;
    }  
    public void changePathOfSlide(){
         pathOfSlide = findPathInArray(SliderController.numberOfSlide);
    } 
    private String findPathInArray(int numOfPath){
        String path = PATHES.get(numOfPath);
        return path;
    }
    public ArrayList<Integer> getEnume() {
        return enume;
    }
    public String getName() {
        return name;
    }
    
    private static ArrayList<String> createPathes(){
        ArrayList<String> list = new ArrayList<>(8);
        list.add("resources/images/ninjaslide.jpg");
        list.add("resources/images/robotslide.jpg");
        list.add("resources/images/alienslide.jpg");
        list.add("resources/images/zombieslide.jpg");
        list.add("resources/images/dinoslide.jpg");
        list.add("resources/images/goblinslide.jpg");
        list.add("resources/images/mageslide.jpg");
        list.add("resources/images/pirateslide.jpg");
        return list;
    }
    private static ArrayList<String> createSpeaches(){
        ArrayList<String> list = new ArrayList<>(8);
        list.add("ninjaspeach");
        list.add("robotspeach");
        list.add("aliensspeach");
        list.add("zombiesspeach");
        list.add("dinospeach");
        list.add("goblinsspeach");
        list.add("magesspeach");
        list.add("piratesspeach");
        return list;
    }
    private static String inputSpeach(){
        ResourceBundle bundle = ResourceBundle.getBundle("prop.changeWords",
                                                         FacesContext.getCurrentInstance().getViewRoot().getLocale());        
        return bundle.getString(SliderController.SPEACHES.get(SliderController.numberOfSlide));
    }
    
}
