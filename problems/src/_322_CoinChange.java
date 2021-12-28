public class _322_CoinChange {

  public int coinChangeRecursion(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    int p = Integer.MAX_VALUE;

    for (int j = 0; j < coins.length; j++) {
      int remainAmt = amount - coins[j];
      if (remainAmt >= 0) {
        int subCoins = coinChangeRecursion(coins, remainAmt);
        if (subCoins != -1) {
          p = Math.min(p, 1 + subCoins);
        }
      }
    }

    if (p == Integer.MAX_VALUE) {
      return -1;
    } else {
      return p;
    }
  }

  public int coinChangeMemoized(int[] coins, int amount) {
    int[] dp = new int[10001];
    return coinChangeAux(coins, amount, dp);
  }

  public int coinChangeAux(int[] coins, int amount, int[] dp) {
    if (amount == 0) {
      return 0;
    }
    if (dp[amount] > 0) {
      return dp[amount];
    }

    int p = Integer.MAX_VALUE;

    for (int j = 0; j < coins.length; j++) {
      int remainAmt = amount - coins[j];
      if (remainAmt >= 0) {
        int subCoins = coinChangeAux(coins, remainAmt, dp);
        if (subCoins != -1) {
          p = Math.min(p, 1 + subCoins);
        }
      }
    }

    if (p == Integer.MAX_VALUE) {
      return -1;
    } else {
      dp[amount] = p;
      return p;
    }
  }

  public int coinChangeBottomUp(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }

    int[] dp = new int[amount + 1];
    for (int i = 1; i <= amount; i++) {
      int p = Integer.MAX_VALUE;
      for (int j = 0; j < coins.length; j++) {
        int remainAmt = i - coins[j];
        if (remainAmt == 0) {
          p = 1;
          break;
        } else if (remainAmt > 0 && dp[remainAmt] > 0) {
          p = Math.min(p, 1 + dp[remainAmt]);
        }
      }
      if (p != Integer.MAX_VALUE) {
        dp[i] = p;
      }
    }

    if (dp[amount] > 0) {
      return dp[amount];
    } else {
      return -1;
    }
  }

  public static void main(String[] args) {
    _322_CoinChange instance = new _322_CoinChange();
    int result;
//    result = instance.coinChangeBottomUp(new int[] {1, 2, 5}, 11);
    result = instance.coinChangeBottomUp(new int[] {2}, 3);
    assert result == -1;
  }
}
