import javax.swing.tree.DefaultMutableTreeNode;

public class CustomMutableTree extends DefaultMutableTreeNode{
    String level, info;

    CustomMutableTree(String name, String level, String text){
        super(name);
        this.level = level;
        this.info = text;
    }

    public String GetLevel() {
        return level;
    }

    public String getInfo(){
        return info;
    }
}
