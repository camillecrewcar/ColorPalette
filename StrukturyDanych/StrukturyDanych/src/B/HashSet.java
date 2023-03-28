package B;

import java.util.Iterator;

public class HashSet {
    private java.util.HashSet<Integer> hashSet;

    public HashSet()
    {
        hashSet = new java.util.HashSet<Integer>();
    }

    public java.util.HashSet<Integer> getHashSet()
    {
        return hashSet;
    }

    public int size()
    {
        return hashSet.size();
    }

    public void insert(int elem)
    {
        if (!member(elem))
        {
            hashSet.add(elem);
        }
    }

    public boolean member(int elem)
    {
        return hashSet.contains(elem);
    }

    public boolean delete(int elem)
    {
        if (member(elem))
        {
            hashSet.remove(elem);
            return true;
        }
        else return false;
    }


    public HashSet union(HashSet secondSet)
    {
        HashSet unionSet = new HashSet();
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext())
        {
            int locElem = iterator.next().intValue();
            unionSet.insert(locElem);
        }

        Iterator<Integer> iteratorS = secondSet.getHashSet().iterator();
        while (iteratorS.hasNext())
        {
            int locElem = iteratorS.next().intValue();;
            unionSet.insert(locElem);
        }

        return unionSet;
    }

    public HashSet intersection(HashSet secondSet)
    {
        HashSet intersectionSet = new HashSet();

        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext())
        {
            int locElem = iterator.next().intValue();
            if (secondSet.member(locElem))
            {
                intersectionSet.insert(locElem);
            }
        }

        return intersectionSet;
    }

    public HashSet difference(HashSet secondSet)
    {
        HashSet differenceSet = new HashSet();

        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext())
        {
            int locElem = iterator.next().intValue();
            if (!secondSet.member(locElem))
            {
                differenceSet.insert(locElem);
            }
        }

        return differenceSet;
    }

    public void print()
    {
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext())
        {
            int locElem = iterator.next().intValue();
            System.out.print(locElem+" ");
        }
        System.out.println();
    }

}
