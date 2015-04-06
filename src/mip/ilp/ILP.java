package mip.ilp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ILP {
	protected ObjectiveFunction objFct;
	protected Set constraints;
	protected Set variables;
	protected VariableNames variableNames;

	public ILP() {
		objFct = new ObjectiveFunction();
		constraints = new HashSet();
		variables = new HashSet();
		variableNames = new VariableNames();
	}

	public void addObjectiveFunctionSummand(double factor, String varName) {
		if (!variableNames.contains(varName)) {
			try {
				Variable var = new Variable();
				variables.add(var);
				variableNames.add(var, varName);
			} catch (VariableNames.UniqueNameException une) {
				// should never happen because the if-statement above makes sure varName is unused
				une.printStackTrace();
			}
		}
		objFct.addSummand(new Summand(factor, varName));
	}

	public void setObjectiveFunctionMinimize(boolean min) {
		objFct.setMinimize(min);
	}

	public void setObjectiveFunctionName(String name) {
		objFct.setName(name);
	}

	public void setVariableLower(String name, double lower) throws UnknownVariableException {
		Variable var = variableNames.getVariable(name);
		if (var == null)
			throw new UnknownVariableException("Variable with name " + name + " is unknown.");
		var.setLower(lower);
	}

	public void setVariableUpper(String name, double upper) throws UnknownVariableException {
		Variable var = variableNames.getVariable(name);
		if (var == null)
			throw new UnknownVariableException("Variable with name " + name + " is unknown.");
		var.setUpper(upper);
	}

	public void setVariableBinary(String name) throws UnknownVariableException {
		Variable var = variableNames.getVariable(name);
		if (var == null)
			throw new UnknownVariableException("Variable with name " + name + " is unknown.");
		var.setBinary();
	}

	public void setVariableGeneral(String name) throws UnknownVariableException {
		Variable var = variableNames.getVariable(name);
		if (var == null)
			throw new UnknownVariableException("Variable with name " + name + " is unknown.");
		var.setGeneral();
	}

	public void setVariableReal(String name) throws UnknownVariableException {
		Variable var = variableNames.getVariable(name);
		if (var == null)
			throw new UnknownVariableException("Variable with name " + name + " is unknown.");
		var.setReal();
	}

	public Constraint createConstraint() {
		Constraint con = new Constraint();
		constraints.add(con);
		return con;
	}

	public void addConstraintSummand(Constraint con, double factor, String varName) {
		if (!variableNames.contains(varName)) {
			try {
				Variable var = new Variable();
				variableNames.add(var, varName);
				variables.add(var);
			} catch (VariableNames.UniqueNameException une) {
				// should never happen because the if-statement above makes sure varName is unused
				une.printStackTrace();
			}
		}
		con.addSummand(new Summand(factor, varName));
	}

	public void setConstraintLess(Constraint con) {
		con.setLess();
	}

	public void setConstraintEqual(Constraint con) {
		con.setEqual();
	}

	public void setConstraintGreater(Constraint con) {
		con.setGreater();
	}

	public void setConstraintRhs(Constraint con, double rhs) {
		con.setRhs(rhs);
	}

	public void setConstraintName(Constraint con, String conName) {
		con.setName(conName);
	}

	public String getBounds(Variable var) throws UnknownVariableException {
		String varName = variableNames.getName(var);
		if (varName == null)
			throw new UnknownVariableException("Variable not registered");
		if (var.getLower() == Integer.MIN_VALUE) {
			if (var.getUpper() == Integer.MAX_VALUE) {
				return (varName + " free");
			} else {
				return ("-inf <= " + varName + " <= " + var.getUpper());
			}
		} else {
			if (var.getUpper() == Integer.MAX_VALUE) {
				return (var.getLower() + " <= " + varName + " <= +inf");
			} else {
				return (var.getLower() + " <= " + varName + " <= " + var.getUpper());
			}
		}
	}

	public Set getConstraints() {
		return constraints;
	}

	public ObjectiveFunction getObjFct() {
		return objFct;
	}

	public VariableNames getVariableNames() {
		return variableNames;
	}

	public Set getVariables() {
		return variables;
	}

	public void writeLP(String outFile, String sourceFile) throws IOException, UnknownVariableException {
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(outFile)));
		out.write("/automatically generated by metromap.ilp.ILP.writeLP()\n");
		out.write("/date of creation " + (DateFormat.getDateTimeInstance()).format(new Date()) + "\n");
		out.write("/source file " + sourceFile);
		out.newLine();
		out.newLine();
		// minimize or maximize
		if (objFct.isMinimize()) {
			out.write("Minimize");
			out.newLine();
		} else {
			out.write("Maximize");
			out.newLine();
		}
		// print objective
		out.write(objFct.toString());
		out.newLine();
		out.newLine();
		// print constraints
		out.write("Subject To");
		out.newLine();
		Iterator it = constraints.iterator();
		while (it.hasNext()) {
			Constraint con = (Constraint) it.next();
			out.write(con.toString());
			out.newLine();
		}
		out.newLine();
		// print bounds
		out.write("Bounds");
		out.newLine();
		it = variables.iterator();
		while (it.hasNext()) {
			Variable var = (Variable) it.next();
			if (!var.isBinary()) {
				out.write(getBounds(var));
				out.newLine();
			}
		}
		out.newLine();
		// print generals
		out.write("General");
		out.newLine();
		it = variables.iterator();
		while (it.hasNext()) {
			Variable var = (Variable) it.next();
			if (var.isGeneral()) {
				out.write(variableNames.getName(var));
				out.newLine();
			}
		}
		out.newLine();
		// print binaries
		out.write("Binary");
		out.newLine();
		it = variables.iterator();
		while (it.hasNext()) {
			Variable var = (Variable) it.next();
			if (var.isBinary()) {
				out.write(variableNames.getName(var));
				out.newLine();
			}
		}
		out.newLine();
		// done
		out.write("End");
		out.newLine();
		out.flush();
		out.close();
	}

	public int numVariables() {
		return variables.size();
	}

	public int numConstraints() {
		return constraints.size();
	}

	public int numLazyConstraints() {
		int counter = 0;
		for (Iterator iter = constraints.iterator(); iter.hasNext();) {
			Constraint element = (Constraint) iter.next();
			if (element.isLazy())
				counter++;
		}
		return counter;
	}

	public static class UnknownVariableException extends Exception {
		public UnknownVariableException(String s) {
			super(s);
		}
	}
}
