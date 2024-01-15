import javax.swing.*;
import javax.swing.tree.*;
import java.io.*;
import java.util.*;



public class mainFile extends TreeFrame {
    static String file="Liv.txt";
    static Scanner sc;

    static CustomMutableTree CreateNode(String line){
        String level = line.substring(line.indexOf('<')+1, line.indexOf(" namn"));
        String name = line.substring(line.indexOf("=\"")+2, line.indexOf("\">"));
        String text = line.substring(line.indexOf('>')+2);
        return new CustomMutableTree(name, level, text);

    }
    //Override method in TreeFrame
    void initTree(){
        try{
            root = CreateNode(sc.nextLine());
            treeModel = new DefaultTreeModel(root);
            tree = new JTree(treeModel);
            buildTree((CustomMutableTree) root);
        }
        catch(Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
    private void buildTree(CustomMutableTree parent){
        String line = sc.nextLine();
        if(line.startsWith("</")){
            if(line.substring(line.indexOf("/")+1, line.indexOf(">")).equals(parent.GetLevel())){
                if(sc.hasNextLine()){
                    CustomMutableTree p = (CustomMutableTree) parent.getParent();
                    buildTree(p);
                }
            }
            else{
                System.out.println("Bad file. Start- and endtag doesn't match.");
                System.out.println(parent.GetLevel());
                System.out.println(line.substring(line.indexOf("/")+1, line.indexOf(">")));
                System.exit(0);
            }
        }
        else{
            CustomMutableTree child = CreateNode(line);
            parent.add(child);
            if(sc.hasNextLine()){
                buildTree(child);
            }
        }
    }

    //Overrides method in TreeFrame
    void showDetails(TreePath p){
        if (p == null){
            return;
        }
        CustomMutableTree pressed_node = (CustomMutableTree) p.getLastPathComponent();
        String text = pressed_node.GetLevel() + ": " + pressed_node + "\nInfo: " + pressed_node.getInfo();
        JOptionPane.showMessageDialog(this, text);
    }
    public static void main(String[] args){
        if(args.length>0)
            file = args[0];
            try{
                sc = new Scanner(new File("src/"+file));
            }
            catch (Exception e){
                System.out.println(e);
                System.exit(0);
            }

        new mainFile();

    }
}
