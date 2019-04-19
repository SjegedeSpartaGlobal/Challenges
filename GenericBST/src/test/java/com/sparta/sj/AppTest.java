package com.sparta.sj;

import static org.junit.Assert.assertTrue;

import com.sparta.sj.Searchers.Exceptions.NodeNotFoundException;
import com.sparta.sj.Searchers.GenericBinarySearchTree;
import com.sparta.sj.Searchers.GenericBinaryTree;
import com.sparta.sj.Searchers.Objects.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * Unit test for simple App.
 */


public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    LinkedList<Employee> employeeList;
    GenericBinaryTree binaryTree;
    public class EmployeeCreator {
        private int age;
        private String name;

        public EmployeeCreator(int age, String name){
            this.age = age;
            this.name = name;
        }
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    public LinkedList<Employee> getEmployeeTestCase(){
        Employee e1 = new Employee(10, "Sam");
        Employee e2 = new Employee(11, "Ben");
        Employee e3 = new Employee(8, "Marrie");
        Employee e4 = new Employee(6, "Dom");
        Employee e5 = new Employee(14, "Dan");

        employeeList = new LinkedList<Employee>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);

        return employeeList;
    }

    @Test
    public void testEmployee(){
        Employee e1 = new Employee(10, "Sam");
        Assert.assertEquals(10, e1.getAge());
    }



    @Test
    public void testGetSortedTreeDesc() {
        try{
            binaryTree = new GenericBinarySearchTree();
            employeeList = getEmployeeTestCase();
            binaryTree.addElements(employeeList);
            List<Employee> newArr = null;
            for (int i = 0; i < newArr.size(); i++) {
                System.out.print(newArr.get(i).getAge() + " ");
            }
            newArr = binaryTree.getSortedTreeDesc();
        } catch (NodeNotFoundException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void testGetSortedTreeAsc(){

        try {
            binaryTree = new GenericBinarySearchTree();
            employeeList = getEmployeeTestCase();
            binaryTree.addElements(employeeList);
            List<Employee> newArr = binaryTree.getSortedTreeAsc();

            for (int i = 0; i < newArr.size(); i++) {
                System.out.print(newArr.get(i).getAge() + " ");
            }
        }catch(NodeNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testFindElement(){
        try {
            binaryTree = new GenericBinarySearchTree();
            employeeList = getEmployeeTestCase();
            Employee e = new Employee(14, "Dan");
            binaryTree.addElements(employeeList);
            assertTrue(binaryTree.findElement(e));
        }catch(NodeNotFoundException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetLeftChild(){
        try {
            binaryTree = new GenericBinarySearchTree();
            employeeList = getEmployeeTestCase();
            Employee e = new Employee(8, "Marrie");
            Employee e2 = new Employee(6, "Dom");
            binaryTree.addElements(employeeList);
            Employee e3 = (Employee) binaryTree.getLeftChild(e);
            Assert.assertEquals(e2.getName(), e3.getName());
        }catch(NodeNotFoundException e){
            System.out.println("message: "+e.getMessage());
        }
    }

}
