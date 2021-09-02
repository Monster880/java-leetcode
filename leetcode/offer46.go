func translateNum(num int) int {
	if num < 10 {
		return 1
	}
	if num >= 10 && num <= 25 {
		return 2
	}
	str := strconv.Itoa(num)
	dp := make([]int, len(str))
	dp[0] = 1
	if str[:2] >= "10" && str[:2] <= "25" {
		dp[1] = 2
	} else {
		dp[1] = 1
	}
	for i := 2; i < len(str); i++ {
		newnum := str[i-1 : i+1]
		if newnum >= "10" && newnum <= "25" {
			dp[i] = dp[i-1] + dp[i-2]
		} else {
			dp[i] = dp[i-1]
		}
	}
	return dp[len(str)-1]
}