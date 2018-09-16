package find.JavaFile;

import java.util.List;
import java.util.Optional;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.DoStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.stmt.SwitchEntryStmt;
import com.github.javaparser.ast.stmt.SwitchStmt;
import com.github.javaparser.ast.stmt.WhileStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class CyclomaticComplexityCalculator {
	
	private List<MethodDeclaration> methodList;
	
	public CyclomaticComplexityCalculator(ClassOrInterfaceDeclaration n) {
		System.out.println(" * " + n.getName());
		methodList=n.getMethods();
		
		exploreMedhods();
	}
	private void exploreMedhods() {
		for (MethodDeclaration method : methodList) {
			
			calculateComplexity(method);
		}
	}
	private void calculateComplexity(MethodDeclaration method) {
		System.out.println("Method Name: " + method.getNameAsString());
		int ifStatement=method.getChildNodesByType(IfStmt.class).size();
		int forStatement=method.getChildNodesByType(ForStmt.class).size();
		int whileStatement=method.getChildNodesByType(WhileStmt.class).size();
		int doWhileStatement=method.getChildNodesByType(DoStmt.class).size();
		int switchStatement=method.getChildNodesByType(SwitchEntryStmt.class).size();
		
		int complexity=ifStatement+forStatement+whileStatement+doWhileStatement+switchStatement+1;
		
		System.out.println("Cyclomatic Complexity:" + complexity);
		
	}
	
    
    
       
	
	
    
	

}
