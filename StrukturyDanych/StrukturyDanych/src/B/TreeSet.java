package B;

import java.util.Iterator;

public class TreeSet {
    private java.util.TreeSet<Integer> treeSet;

    public TreeSet()
    {
        treeSet = new java.util.TreeSet<Integer>();
    }

    public java.util.TreeSet<Integer> getTreeSet()
    {
        return treeSet;
    }

    public int size()
    {
        return treeSet.size();
    }

    public void insert(int elem)
    {
        if (!member(elem))
            treeSet.add(elem);
    }

    public boolean member(int elem)
    {
        return treeSet.contains(elem);
    }

    public boolean delete(int elem)
    {
        if (member(elem))
        {
            treeSet.remove(elem);
            return true;
        }
        else return false;
    }


    public TreeSet union(TreeSet secondSet)
    {

        TreeSet unionSet = new TreeSet();
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext())
        {
            int locElem = iterator.next().intValue();
            unionSet.insert(locElem);
        }

        Iterator<Integer> iteratorS = secondSet.getTreeSet().iterator();
        while (iteratorS.hasNext())
        {
            int locElem = iteratorS.next().intValue();
            unionSet.insert(locElem);
        }

        return unionSet;
    }

    public TreeSet intersection(TreeSet secondSet)
    {
        TreeSet intersectionSet = new TreeSet();

        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext())
        {
            int locElem = iterator.next();
            if (secondSet.member(locElem))
                intersectionSet.insert(locElem);
        }

        return intersectionSet;
    }

    public TreeSet difference(TreeSet secondSet)
    {
        TreeSet differenceSet = new TreeSet();

        Iterator<Integer> iterator = treeSet.iterator();

        while (iterator.hasNext())
        {
            int locElem = iterator.next();
            if (!secondSet.member(locElem))
                differenceSet.insert(locElem);
        }

        return differenceSet;
    }

    public void print()
    {
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext())
        {
            int locElem = iterator.next().intValue();
            System.out.print(locElem+" ");
        }
        System.out.println();
    }
}
