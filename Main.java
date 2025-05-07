public class Main {
    public static void main(String[] args) {
        Set s = new Set(12);
        Set s1 = new Set(5);
        for (int i = 1; i <= 12; i++) s.add(i);
        for (int i = 10; i <= 14; i++) s1.add(i);

        System.out.print("s is ");
        s.displaySet();
        System.out.print("s1 is ");
        s1.displaySet();

        System.out.println("Is s equal to s1? " + s.isEqual(s1));

        System.out.println("Is s1 a subset of s? " + s1.isSubset(s));

        Set unionSet = s.union(s1);
        System.out.print("Union of s and s1 is ");
        unionSet.displaySet();

        Set intersectionSet = s.intersection(s1);
        System.out.print("Intersection of s and s1 is ");
        intersectionSet.displaySet();

        Set diffSet = s.difference(s1);
        System.out.print("Difference of s and s1 is ");
        diffSet.displaySet();

        Set symdiffSet = s.symmetricDifference(s1);
        System.out.print("Symmetric difference of s and s1 is ");
        symdiffSet.displaySet();
    }
}