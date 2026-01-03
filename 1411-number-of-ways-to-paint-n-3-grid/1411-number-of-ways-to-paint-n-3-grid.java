/*
Use colors {A, B, C} (representing R, Y, G).

All permutations where all 3 are different:
ABC
ACB
BAC
BCA
CAB
CBA
total = 6

All permutations where two are same:
ABA
ACA
BAB
BCB
CAC
CBC
total = 6

now this is for n = 1
6 + 6 = 12

now if n = 2
there are possibilities like
we are havig already 3 diff colors

now will these XYZ it can be (3 -> 3)
ABC
XYZ

BCA
CAB
total = 2

now will these XYZ it can be (3 -> 2)
ABA
XYZ

BAB
BCB
total = 2


now will these XYZ it can be (2 -> 3)
ABA
XYZ

BAC
CAB
total = 2

now will these XYZ it can be (2 -> 2)
ABA
XYZ

BAB
BCB
CAB
total = 3

these are total possiblities that can be possible.

*/
class Solution {
  public int numOfWays(int n) {
    int MOD = 1_000_000_007;
    if (n == 0) {
      return 0;
    }

    long pick_two  = 6, pick_three = 6;
    n--;

    while(n-- > 0){
      long pick_next_three = (pick_three * 2 + pick_two * 2) % MOD;
      /*
      if(3 -> 3) 2 possibilities
      if(3 -> 2) 2 possibilities
      */

      long pick_next_two = (pick_three * 2 + pick_two * 3) % MOD;
      /*
      if(2 -> 3) 2 possibilities
      if(2 -> 2) 3 possibilities
      */

      pick_three = pick_next_three;
      pick_two = pick_next_two;
    }
    return (int) (pick_two + pick_three) % MOD;
  }
}