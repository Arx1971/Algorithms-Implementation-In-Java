package StringManipulation.CountNumberOfPalindromicSubstringInAString;

public class Main {

    public static void main(String[] args) {

        System.out.println(numberOfPalindromicSubstringInAString("fjdsklfjslkdjflksdfjlsdieaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaanvineinvoienovnwoinvoiwenfefoefnoeinvonoinefdfs" +
                "jflkdsjfsjfoenvneoivneoivneoinvowinvwneovnavnfnanvvjkejvnjsdnkdsjfniuwdfnkjsfnfjdsklfjslkdjflk" +
                "sdfjlsdieaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaanvineinvoienovnwoinvoiwenfefoefnoeinvo" +
                "noinefdfsjflkdsjfsjfoenvneoivneoivneoinvowinvwneovnavnfnanvvjkejvnjsdnkdsjfniuwdfnkjsfnfjdsklf" +
                "jslkdjflksdfjlsdieaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaanvineinvoienovnwoinvoiwenfe" +
                "foefnoeinvonoinefdfsjflkdsjfsjfoenvneoivneoivneoinvowinvwneovnavnfnanvvjkejvnjsdnkdsjfniuwdfn" +
                "kjsfnfjdsklfjslkdjflksdfjlsdieaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaanvineinvoienov" +
                "nwoinvoiwenfefoefnoeinvonoinefdfsjflkdsjfsjfoenvneoivneoivneoinvowinvwneovnavnfnanvvjkejvnjsd" +
                "nkdsjfniuwdfnkjsfnfjdsklfjslkdjflksdfjlsdieaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaan" +
                "vineinvoienovnwoinvoiwenfefoefnoeinvonoinefdfsjflkdsjfsjfoenvneoivneoivneoinvowinvwneovnavnf" +
                "nanvvjkejvnjsdnkdsjfniuwdfnkjsfnfjdsklfjslkdjflksdfjlsdieaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaanvineinvoienovnwoinvoiwenfefoefnoeinvonoinefdfsjflkdsjfsjfoenvneoivneoivneoinv" +
                "owinvwneovnavnfnanvvjkejvnjsdnkdsjfniuwdfnkjsfnfjdsklfjslkdjflksdfjlsdieaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaanvineinvoienovnwoinvoiwenfefoefnoeinvonoinefdfsjflkdsjfsjfoenvneoivneoivneo" +
                "invowinvwneovnavnfnanvvjkejvnjsdnkdsjfniuwdfnkjsfnfjdsklfjslkdjflksdfjlsdieaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaanvineinvoienovnwoinvoiwenfefoefnoeinvonoinefdfsjflkdsjfsjfoenvneoivneoivneoinvowinvwneo" +
                "vnavnfnanvvjkejvnjsdnkdsjfniuwdfnkjsfnfjdsklfjslkdjflksdfjlsdieaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaanvineinvoi" +
                "enovnwoinvoiwenfefoefnoeinvonoinefdfsjflkdsjfsjfoenvneoivneoivneoinvowinvwneovnavnfnanvvjkejvnjsdnkdsjfniuw" +
                "dfnkjsfnfjdsklfjslkdjflksdfjlsdieaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaanvineinvoienovnwoinvoiwenfefoefnoeinv" +
                "onoinefdfsjflkdsjfsjfoenvneoivneoivneoinvowinvwneovnavnfnanvvjkejvnjsdnkdsjfniuwdfnkjsfnfjdsklfjslkdjflksd" +
                "fjlsdieaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaanvineinvoienovnwoinvoiwenfefoefnoeinvonoinefdfsjflkdsjfsjfoenvne" +
                "oivneoivneoinvowinvwneovnavnfnanvvjkejvnjsdnkdsjfniuwdfnkjsfnfjdsklfjslkdjflksdfjlsdieaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaanvineinvoienovnwoinvoiwenfefoefnoeinvonoinefdfsjflkdsjfsjfoenvneoivneoivneoinvowinvwneovna" +
                "vnfnanvvjkejvnjsdnkdsjfniuwdfnkjsfnfjdsklfjslkdjflksdfjlsdieaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaanvineinvoi" +
                "enovnwoinvoiwenfefoefnoeinvonoinefdfsjflkdsjfsjfoenvneoivneoivneoinvowinvwneovnavnfnanvvjkejvnjsdnkdsjfniuw" +
                "dfnkjsfnfjdsklfjslkdjflksdfjlsdieaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaanvineinvoienovnwoinvoiwenfefoefnoe" +
                "invonoinefdfsjflkdsjfsjfoenvneoivneoivneoinvowinvwneovnavnfnanvvjkejvnjsdnkdsjfniuwdfnkjsfnfjdsklfjslkdjf" +
                "lksdfjlsdieaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaanvineinvoienovnwoinvoiwenfefoefnoeinvonoinefdfsjflkdsjfs" +
                "jfoenvneoivneoivneoinvowinvwneovnavnfnanvvjkejvnjsdnkdsjfniuwdfnkjsfnfjdsklfjslkdjflksdfjlsdieaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaanvineinvoienovnwoinvoiwenfefoefnoeinvonoinefdfsjflkdsjfsjfoenvneoivneoivneoinvo" +
                "winvwneovnavnfnanvvjkejvnjsdnkdsjfniuwdfnkjsfnfjdsklfjslkdjflksdfjlsdieaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaanvineinvoienovnwoinvoiwenfefoefnoeinvonoinefdfsjflkdsjfsjfoenvneoivneoivneoinvowinvwneovnavnfnanvvjkej" +
                "vnjsdnkdsjfniuwdfnkjsfnfjdsklfjslkdjflksdfjlsdieaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaanvineinvoienovnwoinv" +
                "oiwenfefoefnoeinvonoinefdfsjflkdsjfsjfoenvneoivneoivneoinvowinvwneovnavnfnanvvjkejvnjsdnkdsjfniuwdfnkjsfn" +
                "fjdsklfjslkdjflksdfjlsdieaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaanvineinvoienovnwoinvoiwenfefoefnoeinvonoine"));
    }

    public static int numberOfPalindromicSubstringInAString(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += countPalindrome(str, i, i);
            count += countPalindrome(str, i, i + 1);
        }
        return count;
    }

    public static int countPalindrome(String str, int i, int j) {
        int counter = 0;
        while (i >= 0 && j < str.length() && str.charAt(j) == str.charAt(i)) {
            counter++;
            i--;
            j++;
        }
        return counter;
    }

}
