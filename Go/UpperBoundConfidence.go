package UpperBoundConfidence

import "math"

func UpperBoundConfidence(dataSet [][]float64) (float64, []float64, []float64, []int) {
	// full dataset
	N := dataSet
	// list of objects
	d := dataSet[0]

	// list of positives on each round
	var selected []int

	// Creates Vector of selections set to 0
	numberOfSelections := initializeNilIntSlice(len(d))

	// Number of times each item was positive
	sumOfRewards := initializeNilIntSlice(len(d))

	// Total times it was correct
	totalReward := float64(0)

	// Ranges over datset
	for n := 0; n < len(N); n++ {
		x := 0
		//log.Println(n)
		maxUpperBound := float64(0)
		// Ranges over items
		for j := 0; j < len(d); j++ {
			upperBound := float64(0)
			// This makes sure that only one of the 10 adds is selected at a time
			if numberOfSelections[j] > 0 {
				averageReward := sumOfRewards[j] / numberOfSelections[j]
				// This is a constant -- DO NOT CHANGE --
				deltaI := math.Sqrt(3 / 2 * math.Log(float64(n+1)) / float64(numberOfSelections[j]))
				upperBound = float64(averageReward) + deltaI
			} else {
				/*
								First iteration upper bound equal to 1^400,
				            	Very large because it needs to evaluate to true on the first
				            	iteration
				*/
				upperBound = math.Pow(10, 400)
			}
			if upperBound > maxUpperBound {
				maxUpperBound = upperBound
				x = j
			}
		}
		// Adds the item that was chosen to the list
		numberOfSelections[x] = numberOfSelections[x] + 1

		// Adds overall count of the item chosen to keep track
		selected = append(selected, x)

		// get value of reward, n = {row}, item = {item selected}
		reward := dataSet[n][x]

		// Increment the times the item has been selected by 1 {the reward}
		sumOfRewards[x] = sumOfRewards[x] + float64(reward)

		// The amount of times the model was correct
		totalReward = totalReward + reward
	}
	return totalReward, sumOfRewards, numberOfSelections, selected

}

// Creates a list of float64(0) of N size
func initializeNilIntSlice(n int) []float64 {
	var negativeList []float64
	for i := 0; i < n; i++ {
		negativeList = append(negativeList, 0)
	}
	return negativeList
}
