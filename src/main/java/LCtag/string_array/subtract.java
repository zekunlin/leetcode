package LCtag.string_array;

public class subtract {
    public class Main {
        public static void main(String[] args) {
            int[] array1 = {1, 2, 3, 5};
            int[] array2 = {1, 2, 3, 4};

            int[] res = minusTwo(array1, array2);
            System.out.println(Arrays.toString(res));
        }

        public static int[] minusTwo(int[] A, int[] B) {
            //corner case
            if(A == null && B == null) {
                throw new IllegalArgumentException("INVALID INPUT");
            }
            if(A == null || A.length == 0) return B;
            if(B == null || B.length == 0) return A;
            int lenA = A.length;
            int lenB = B.length;
            if(lenA < lenB) {
                return minusTwo(B, A);
            }else if(lenA == lenB) {
                int i = 0;
                for(i = 0; i < lenA; i++) {
                    if(A[i] < B[i]) {
                        return minusTwo(B, A);
                    }else if(A[i] > B[i]){
                        break;
                    }
                }
                if(i == lenA) return new int[]{0};
            }
            int i = lenA - 1;
            int j = lenB - 1;
            int[] res = new int[lenA];
            int carry = 0;
            while(lenA-- > 0) {
                int numA = i < 0 ? 0 : A[i];
                int numB = j < 0 ? 0 : B[j];
                if(numA + carry >= numB) {
                    res[i] = numA - numB + carry;
                    carry = 0;
                }else {
                    res[i] = numA + 10 - numB + carry;
                    carry = -1;
                }
                i--;
                j--;
            }
            int start = 0;
            for(start = 0; start < res.length; start++) {
                if(res[start] != 0) {
                    break;
                }
            }
            return Arrays.copyOfRange(res, start, res.length);
        }
    }
}
