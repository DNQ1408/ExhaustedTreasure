package Scene;
public class SceneManager {
    public static SceneManager instance = new SceneManager();
    private Scene currentScene;
    private Scene nextScene;
    public void changScene(Scene scene){
        this.nextScene = scene;
    }

    public void performChangSceneIfNeeded(){
        if (nextScene != null){
            if (this.currentScene != null){
                this.currentScene.deinit();
            }
            this.nextScene.init();
            this.currentScene = this.nextScene;
            this.nextScene = null;
        }
    }

}
