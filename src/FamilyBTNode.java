
public class FamilyBTNode {
  String firstName;
  String lastName; 
  FamilyBTNode mother; 
  FamilyBTNode father;
  
  FamilyBTNode(String inFirst, String inLast){
    firstName = inFirst; 
    lastName = inLast;
  }
  
  public String relationship(FamilyBTNode inNode, int levels) {
    
    if(this == inNode) return "Self";
    else if(father == inNode) {
      if(levels == 0) return "Father";
      if(levels == 1) return "Grandfather";
      else {
        String rtn = "";
        for(int i=2; i<=levels; i++) {
          rtn += "Great ";
        }
        return rtn + "Grandfather";
      }
    }
    else if(mother == inNode) {
      if(levels == 0) return "Mother";
      if(levels == 1) return "Grandmother";
      else {
        String rtn = "";
        for(int i=2; i<=levels; i++) {
          rtn += "Great ";
        }
        return rtn + "Grandmother";
      }
    }else {
      if(mother.inSubtree(inNode)) {
        return mother.relationship(inNode, levels + 1);
      }

      if(father.inSubtree(inNode)) {
        return father.relationship(inNode, levels + 1);
      }
    }
    return "Not Found";
  }
  
  public boolean inSubtree(FamilyBTNode inNode) {
    boolean rtn = false;
    if(this == inNode) return true;
    if(father != null) rtn |= father.inSubtree(inNode);
    if(mother != null) rtn |= mother.inSubtree(inNode);
    return rtn;
  }
  
  public void print() { print(""); }
  
  public void print(String prepend) {
    System.out.print(prepend + "\"" + firstName + " " + lastName + "\"");
    if(father!=null || mother!=null) {
      System.out.println("{");
      if(mother!=null) mother.print(prepend + "m  ");
      if(father!=null) father.print(prepend + "f  ");
      System.out.print(prepend + "}");
    }
    System.out.println();
  }
}
