package find.JavaFile;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;

public class WeightedMethodCount {
	public WeightedMethodCount(ClassOrInterfaceDeclaration n) {
		System.out.println(" * " + n.getName());
		System.out.println("WMC: " + n.getMethods().size());
	}

}
