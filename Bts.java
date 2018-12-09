/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bts;

import java.util.Stack;

/**
 *
 * @author Samran
 */
public class Bts {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        trees obj=new trees();
        obj.insert(12);
        obj.insert(10);
        obj.insert(13);
        obj.insert(9);
        obj.insert(2);
        //obj.Print();
        obj.printLevelOrder();
        obj.pp();
        obj.iterativePreorder();
       
    }
    
}
class node
{
    int data;
    node right;
    node left;
    node(int data)
    {
        this.data=data;
        right=null;
        left=null;
        
    }
}
class trees
{
     node root ;
     void insertt(int data,node temp)
     {  
         node dat=new node(data);
         if(root ==null)
         {
             root=new node(data);
         }
         else if (temp.left==null && temp.right==null)
         {
             if(data>temp.data)
             {
                 temp.right=dat;
             }
             else if(data<temp.data)
             {
                 temp.left=dat;
                 
             }
             else if(data==temp.data)
             {
                 System.out.println("repetiotion not allowed in this tree bro sorry ");
             }
         }
         else
         {
             if(data>temp.data)
             {
                if(temp.right==null)
                {
                    temp.right=dat;
                }
               
                else
                {
                    temp=temp.right;
                    insertt(data,temp);
                }
               
             }
             else if(data<temp.data)
             {
                if(temp.left==null)
                {
                    temp.left=dat;
                }
                else 
                {
                    temp=temp.left;
                    insertt(data,temp);
                }
               
             }
             
         }
         
     }
     void insert(int data)
     {
         insertt(data,root);
     }
     node search(int data,node temp)
     {
         
         if(temp==null)
         {
             System.out.println("There is no data in tree bitch ");
         }
          if(temp.data==data)
         {
           return temp;      
         }
          if(data>temp.data)
          {   
              temp=temp.right;
              if(temp.data==data)
              {
                  return temp;
              }
               if(data>temp.data)
               {
                temp=temp.right;
                 return search(data,temp);
                }
                if(data<temp.data)
               {
                   temp=temp.left;
                   return search(data,temp);
               }
               
          }
          else if(data<temp.data)
          {
            temp=temp.left;
            if(temp.data==data)
            {
                return temp;
            }
             if(data>temp.data)
            {   
               temp=temp.right;
                return search(data,temp);
            }
              if(data<temp.data)
             {
                 temp=temp.left;
                 return search(data,temp);
                
             }
             
          }
          return null;
     }
     node parent(int data)
     {
         node temp;
         temp=root;
         node parentt=temp;
         node LastResort=new node(0);
         if(root==null)
         {
             System.out.println("There is no data in tree bitch ");
         }
          if(temp.data==data)
         {
           return parentt;      
         }
          if(data>temp.data)
          {   parentt=temp;
              temp=temp.right;
              if(temp.data==data)
              {
                  return parentt;
              }
               if(data>temp.data)
               {
                temp=temp.right;
                search(data,root);
                }
                if(data<temp.data)
               {
                   temp=temp.left;
                   parent(data);
               }
               
          }
          else if(data<temp.data)
          { parentt=temp;
            temp=temp.left;
            if(temp.data==data)
            {
                return parentt;
            }
             if(data>temp.data)
            {   
               temp=temp.right;
                parent(data);
            }
              if(data<temp.data)
             {
                 temp=temp.left;
                 parent(data);
                
             }
             
          }
          return LastResort; 
     }

     void Print()
     {   //node temp=root;
     
        /* if(root==null)
         {
             System.out.println("no data in tree");
         }
         else 
         {
             
         }*/
        node temp=search(2,root);
        if(temp.data==2)
        {
            System.out.println("found yes yay !");
        }
     }
     int height(node root,int l,int r)
     {  
        if(root == null)
            return -1;
        else 
        {
            height(root.left,l,r);
            l++;
            height(root.right,l,r);
            r++;
            if(r>=l)
                return r;
            else 
                return l;
        }
     }
     void printLevelOrder()
     {   node temp=root;
     
         int h=height(temp,0,0);
                 temp=root;
         for(int i=1;i<=h;i++)
         {
             printGivenLevel(temp, i);
         }
     }
       void printGivenLevel (node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
       void preorder(node temp)
       {
           if(temp==null)
               return ;
           else 
           {   System.out.println(" "+temp.data);
               
               preorder(temp.left);
               preorder(temp.right);
           }
       }
     void p()
     {  node temp=root;
         preorder(temp);
     }
     void postorder(node temp)
     {
         if(temp==null)
         {
             return ;
         }
         else 
         {
             postorder(temp.left);
             postorder(temp.right);
             System.out.println(temp.data);
         }
     }
     void pp()
     {  node temp=root;
         postorder(temp);
     }
     void iterativePreorder()
    {
        PPreorder(root);
    }
    
    void PPreorder(node temp)
    {
        if (temp == null) 
        {
            return;
        } 
        Stack<node> ns = new Stack<node>();
        
        ns.push(root);
        
        while (ns.empty()==false) 
        {
            node mynode = ns.peek();
            System.out.print(mynode.data + " ");
            ns.pop();
            if (mynode.right!=null) {
                ns.push(mynode.right);
            }
            if (mynode.left != null) {
                ns.push(mynode.left);
            }
        }
    }
      node GetHightLeftSubtree()
     {
        node temp=root;
        
        if(temp.left!=null)
            temp=temp.left;
        while(temp.right!=null)
        {
            temp=temp.right;
        }
        return temp;
     }
      void delete(int data)
     {
        node c= search(data ,root);
        node p=parent(data);
        node temp;
        if(c.left==null && c.right==null)
        {
            c=null;
        }
        // case 2 one child is null
        else if(c.left==null || c.right== null)
        {
            if(c.left==null)
            {
                temp=c.right;
                if(p.left==c)
                 p.left=temp;
                else 
                   p.right = temp;
                 c=null;
                
            }
            if(c.right==null)
            {
                temp=c.left;
                if(p.left==c)
                 p.left=temp;
                else 
                   p.right = temp;
                c=null;
                
            }
        }
        else if(c.left!=null && c.right!=null)
        {
            temp=GetHightLeftSubtree();
            node pl=parent(temp.data);
            if(temp.left!=null)
            {
                pl.right=temp.left;
            }
            if(p.left==c)
            {
                p.left=temp;
                temp.left=c.left;
                temp.right=c.right;
            }
            if(p.right==c)
            {
                p.right=temp;
                temp.left=c.left;
                temp.right=c.right;
            }
            c=null;
        }
        else 
             System.out.println("ERROR !");
        
     }
}
