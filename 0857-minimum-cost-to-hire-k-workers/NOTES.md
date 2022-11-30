​
2. Let's assume we decide to pay worker[1] == wage[1]
- offer[0]/offer[1] = quality[0]/quaity[1]
- offer[0] = (quality[0]/ quality[1]) * offer[1]
- offer[0] = (10/20) * 50 = 0.5 * 50 = 25
- But wage[0] = 70 > 25 => Hence, we cannot pay this person
---
- offer[2]/offer[1] = quality[2]/quaity[1]
- offer[2] = (quality[2]/ quality[1]) * offer[1]
- offer[2] = (5/20) * 50 = 0.25 * 50 = 12.5
- But wage[2] = 30 > 12.5 => Hence, we cannot pay this person
Cannot pay anyone if we try to pay minimum wage to worker[1]
​
2. Let's assume we decide to pay worker[0] == wage[0]
- offer[1]/offer[0] = quality[1]/quaity[0]
- offer[1] = (quality[1]/ quality[0]) * offer[0]
- offer[1] = (20/10) * 70 = 2 * 70 = 140
- But wage[1] = 50 < 140 => Hence, we can pay this person
---
- offer[2]/offer[0] = quality[2]/quaity[0]
- offer[2] = (quality[2]/ quality[0]) * offer[0]
- offer[2] = (5/10) * 70 = 0.5 * 70 = 35
- But wage[2] = 30 < 35 => Hence, we can pay this person
pay [70, 140, 35]
only choose the smallest two
​
---
Improvements
offer[i] >= wage[i] (only then we can take this worker into consideration)
offer[i]/ wage[j] = quality[i]/ quality[j]
offer[i] = quality[i] * (wage[j] / quality[j])
quality[i] * (wage[j] / quality[j]) >= wage[i]
quality[i] * ratio[j] >= wage[i]
ratio[j] >= wage[i] / quality[i]
ratio[j] >= ratio[j]
​
-- Find all ratios (wage[i] / quality[i])
-- Sort all the ratios
-- Choose a captain