class LegacyAPI {
    @Deprecated(since = "1.8", forRemoval = true)
    public void oldFeature() {
        System.out.println("This is the old feature. Please use newFeature() instead.");
    }

    public void newFeature() {
        System.out.println("This is the new and improved feature!");
    }
}

public class LegacyAPIMain{
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        
        api.oldFeature(); 
        api.newFeature(); 
    }
}
