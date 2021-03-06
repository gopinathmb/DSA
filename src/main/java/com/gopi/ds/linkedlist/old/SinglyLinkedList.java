/**
 * Created by gopinath_mb on 29-Mar-2020
 */
package com.gopi.ds.linkedlist.old;

import java.util.Arrays;

/**
 * @author gopinath_mb
 */
public class SinglyLinkedList
{

  Node head;

  Node last;

  public static void main(String[] args)
  {
//    SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
//    singlyLinkedList.createLinkedList(1, 2, 3, 9, 5, 6);
//    singlyLinkedList.display();
//    System.out.println("Displaying Linked List elements Recursively... ");
//    singlyLinkedList.displayRecursively(singlyLinkedList.head);
//
//    System.out.println("\nDisplaying Linked List elements in Reverse Recursively... ");
//    singlyLinkedList.displayReverseRecursively(singlyLinkedList.head);
//
//    System.out.println("\nSum of Elements Data :" + singlyLinkedList.sumOfElementsData(singlyLinkedList.head));
//
//    System.out.println("Number of Nodes in LL :" + singlyLinkedList.count(singlyLinkedList.head));
//
//    System.out.println("Max element in the Linked list is : " + singlyLinkedList.max(singlyLinkedList.head));
//    singlyLinkedList.display();
//    singlyLinkedList.insert(20, 0);
//    singlyLinkedList.insert(30, 4);
//    singlyLinkedList.insert(50, 9);
//    singlyLinkedList.display();
//    SinglyLinkedList singlyLinkedList2 = new SinglyLinkedList();
//    singlyLinkedList2.insertLast(60);
//    singlyLinkedList2.insertLast(70);
//    singlyLinkedList2.insertLast(90);
//    singlyLinkedList2.display();
//
//    SinglyLinkedList singlyLinkedList3 = new SinglyLinkedList();
//    singlyLinkedList3.insertInSortedList(30);
//    singlyLinkedList3.insertInSortedList(20);
//    singlyLinkedList3.insertInSortedList(10);
//    singlyLinkedList3.insertInSortedList(40);
//    singlyLinkedList3.insertInSortedList(25);
//    singlyLinkedList3.display();
//
//    singlyLinkedList3.delete(0);
//    singlyLinkedList3.delete(1);
//    singlyLinkedList3.delete(2);
//    singlyLinkedList3.delete(0);
//    singlyLinkedList3.delete(4);
//
//    SinglyLinkedList singlyLinkedList4 = new SinglyLinkedList();
//    singlyLinkedList4.createLinkedList(2, 2, 4, 5, 6, 6, 7, 7, 7, 7, 8, 8, 8);
//    singlyLinkedList4.removeDuplicates();
//
//    SinglyLinkedList list5 = new SinglyLinkedList();
//    list5.createLinkedList(1, 2, 3, 4, 5);
//    list5.reverseLinkedList();
//
    SinglyLinkedList    list5 = new SinglyLinkedList();
    list5.createLinkedList(1, 2, 3, 4, 5);
    list5.display();
    list5.reverseLinkedListRecursively(list5.head);
    list5.display();

//    SinglyLinkedList list1 = new SinglyLinkedList();
//    list1.createLinkedList(30, 40, 50, 60, 70);
//    SinglyLinkedList list2 = new SinglyLinkedList();
//    list2.createLinkedList(5, 15, 25, 35, 45, 55, 65, 75, 85, 95);
//    mergeTwoLists(list1, list2);

//    SinglyLinkedList list1 = new SinglyLinkedList();
//    list1.createLinkedList(30, 40, 50, 60, 70, 80, 90, 20);
//    list1.hasLoop();
//
//    list1 = new SinglyLinkedList();
//    list1.createLinkedList(30, 40, 50, 60, 70, 80, 90, 20);
//    Node temp1 = list1.head;
//    temp1 = temp1.next;
//    Node temp2 = list1.head;
//    temp2 = temp2.next.next.next.next;
//    temp2.next = temp1;
//
//    list1.hasLoop();

  }

  /**
   * 
   */
  private void reverseLinkedList()
  {
    System.out.print("\nBefore Reversing :");
    display();
    Node prev = null, cur, next;
    cur = head;
    while (null != cur)
    {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    head = prev;
    System.out.print("\nAfter Reversing :");
    display();
  }

  private Node reverseLinkedListRecursively(Node temp)
  {
    if (temp == null || temp.next == null)
    {
      head.next = null;
      head = temp;
      return temp;

    } else
    {
      return reverseLinkedListRecursively(temp.next).next = temp;
    }
  }

  private void hasLoop()
  {
    Node single = head, second = head;
    do
    {
      second = second.next;
      if (second == null)
      {
        break;
      }
      single = single.next;
      second = second.next;
    } while (single != null && second != null && single != second);
    if (single == second)
    {
      System.out.println("There is a Loop..");
    } else
    {
      System.out.println("No Loop..");
    }

  }

  public static void mergeTwoLists(SinglyLinkedList list1,
      SinglyLinkedList list2)
  {
    System.out.print("Merging First list : ");
    list1.display();
    System.out.print(" and 2nd List : ");
    list2.display();
    if (list1 == null || list2 == null || list1.head == null
        || list2.head == null)
    {
      System.out.println("As one of the list in empty so no merging..");
      return;

    }
    Node head = null;
    Node last = null;
    Node first = list1.head;
    Node second = list2.head;
    if (first.data < second.data)
    {
      head = first;
      last = first;
      first = first.next;

    } else
    {

      head = second;
      last = second;
      second = second.next;

    }
    while (first != null && second != null)
    {
      if (first.data < second.data)
      {
        last.next = first;
        last = first;
        first = first.next;
      } else
      {

        last.next = second;
        last = second;
        second = second.next;

      }
    }

    if (first == null)
    {
      last.next = second;
    } else
    {
      last.next = first;
    }

    System.out.print("\nLinked List after Merging is : ");
    Node temp = head;
    while (temp != null)
    {
      System.out.print(" " + temp.data);
      temp = temp.next;

    }
  }

  /**
   * 
   */
  public Node createLinkedList(int... elements)
  {
    head=null;
    last=null;
    System.out.println(
        "Creating LinkedList with elements: " + Arrays.toString(elements));
    for (int i : elements)
    {
      insertAtTheEnd(i);
    }
    return head;
  }

  public void insertAtTheEnd(int dataElement)
  {
    Node node = new Node(dataElement);
    if (null == head)
    {
      head = node;
    } else
    {
      Node temp = head;
      while (temp.next != null)
      {
        temp = temp.next;
      }
      temp.next = node;
    }
  }

  public void display()
  {
    System.out.print("\nDisplaying Elements : ");
    Node temp = head;
    while (null != temp)
    {
      System.out.print(temp.data + " ");
      temp = temp.next;

    }
  }

  public void insert(int data, int pos)
  {
    Node node = new Node(data);

    if (pos == 0 || head == null)
    {
      node.next = head;
      head = node;
    } else if (pos > 0)
    {
      Node temp = head;
      for (int i = 0; i < pos - 1 && temp.next != null; i++)
      {
        temp = temp.next;
      }
      node.next = temp.next;
      temp.next = node;
    }
  }

  public void insertLast(int data)
  {
    Node node = new Node(data);

    if (head == null)
    {
      last = head = node;
    } else
    {
      last.next = node;
      last = node;
    }
  }

  public void insertInSortedList(int data)
  {
    Node node = new Node(data);

    if (head == null)
    {
      last = head = node;
    } else
    {

      Node next = head;
      Node prev = null;
      if (head.data > data)
      {
        node.next = head;
        head = node;
        return;
      }
      while (next != null && next.data < data)
      {
        prev = next;
        next = next.next;

      }
      node.next = prev.next;
      prev.next = node;
    }
  }

  public void delete(int pos)
  {
    if (head != null)
    {

      if (pos == 0)
      {
        Node temp = head;
        head = head.next;
        temp = null;

      } else
      {

        Node next = head;
        Node prev = null;
        int count = 0;
        while (next != null && pos > count++)
        {
          prev = next;
          next = next.next;

        }
        if (next != null)
        {
          prev.next = next.next;
          next.next = null;
        } else
        {
          System.out.print(
              "\nAs position given :" + pos + " doesn't exist in the List");
          display();
        }
      }
    }
    System.out
        .print("\nAfter Deleting element at pos: " + pos + " from List: ");
    display();
  }

  public void removeDuplicates()
  {
    System.out.print("\nBefore Deleting of Duplicates ");
    display();
    Node cur = head;
    Node next = head.next;
    while (next != null)
    {

      if (cur.data != next.data)
      {
        cur = next;
        next = next.next;
      } else
      {
        cur.next = next.next;
        next.next = null;
        next = cur.next;
      }
    }
    System.out.print("\nAfter  Deleting of Duplicates ");
    display();

  }

  public void displayRecursively(Node temp)
  {
    if (temp == null)
    {
      return;
    }
    System.out.print(temp.data + " ");
    displayRecursively(temp.next);

  }

  public void displayRecursively2(Node temp)
  {
    if (null != temp)
    {
      System.out.print(temp.data + " ");
      displayRecursively(temp.next);
    }

  }

  public void displayReverseRecursively(Node temp)
  {
    if (null != temp)
    {
      displayReverseRecursively(temp.next);
      System.out.print(temp.data + " ");
    }

  }

  public int sumOfElementsData(Node head)
  {
    if (null == head)
    {
      return 0;
    }
    return (head.data + sumOfElementsData(head.next));

  }

  public int count(Node head)
  {
    if (null == head)
    {
      return 0;
    }
    return (1 + count(head.next));

  }

  public int max(Node head)
  {
    int max = Integer.MIN_VALUE;
    if (null == head)
    {
      return max;
    } else
    {
      max = max(head.next);
      if (max > head.data)
      {
        return max;
      } else
      {

        return head.data;
      }
    }
  }

}
