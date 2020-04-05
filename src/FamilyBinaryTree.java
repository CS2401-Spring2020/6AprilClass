
public class FamilyBinaryTree {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    FamilyBTNode root = new FamilyBTNode("Kylo", "Ren");
    root.father = new FamilyBTNode("Han","Solo");
    root.mother = new FamilyBTNode("Princes","Leia");
    root.mother.mother = new FamilyBTNode("Queen","Padme");
    root.mother.father = new FamilyBTNode("Anakin","Skywalker");
    root.mother.father.mother = new FamilyBTNode("Shimi", "Skywalker");
    root.mother.mother.mother = new FamilyBTNode("Jobal","Naberrie");
    root.mother.mother.father = new FamilyBTNode("Ruweee","Naberrie");
    root.mother.mother.father.father = new FamilyBTNode("Who","Knows");
    
    root.print();
    
    System.out.println(root.firstName + ">" + root.mother.firstName + ": " + root.relationship(root.mother, 0));    
    System.out.println(root.firstName + ">" + root.mother.mother.firstName + ": " + root.relationship(root.mother.mother, 0));
    System.out.println(root.firstName + ">" + root.mother.mother.father.firstName + ": " + root.relationship(root.mother.mother.father, 0));
    System.out.println(root.firstName + ">" + root.mother.mother.father.father.firstName + ": " + root.relationship(root.mother.mother.father.father, 0));
    
    System.out.println(root.mother.mother.firstName + ">" + root.mother.mother.father.father.firstName + ": " + root.mother.mother.relationship(root.mother.mother.father.father, 0));
    
    
  }

}
