
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
    if(inNode == this) return "Self";
    if(inNode == mother) {
      if(levels == 0) return "Mother";
      if(levels == 1) return "Grandmother";
      else {
        String rtn = "";
        for(int i=2; i<=levels; i++) {
          rtn += "Great ";
        }
        rtn += "Grandmother";
        return rtn;
      }
    }
    if(inNode == father) {
      if(levels == 0) return "Father";
      if(levels == 1) return "Grandfather";
      else {
        String rtn = "";
        for(int i=2; i<=levels; i++) {
          rtn += "Great ";
        }
        rtn += "Grandfather";
        return rtn;
      }
    }
    if(mother != null && mother.inSubtree(inNode)) {
      return mother.relationship(inNode, levels+1);
    }else if(father != null && father.inSubtree(inNode)) {
      return father.relationship(inNode, levels+1);
    }
    return "No Relationship";

  }
  
  public boolean inSubtree(FamilyBTNode inNode) {
    if(inNode == null) return false;
    if(inNode == this) return true; // `this` can never be null
    // mother.inSubtree(inNode) || father.inSubtree(inNode) 
    
    boolean rtn = false;
    if(mother != null) rtn = (rtn || mother.inSubtree(inNode));
    if(father != null) rtn |= father.inSubtree(inNode);
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
