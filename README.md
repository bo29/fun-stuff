# fun-stuff
These are files where I write algorithms that perform specific functions. Thus far I have:

bozosort.java
	Bogosort is notorious for being an ineffective sorting algorithm. It sorts by shuffling an array over and over until it is sorted. It is estimated that the algorithm is O(n!) if duplicate shuffles are not allowed and potentially O(infinity) if they can be reused. Bozosort is an offshoot of bogosort and my program is based on the algorithm's description on Wikipedia. The way it works is that it will check an array and as long as it is not sorted (which is already O(n)), then it will swap two random elements. This works fast enough for small arrays, but going past ~15 entries can take up to a minute and I've never seen an array with more than 25 elements finish sorting, even after 6 hours. Theoretically, with a size of 52 (like a standard deck of cards), bogosort and bozosort should not be able to finish before the death of the planet Earth.
	
MontyHall.java
	The Monty Hall problem is a well-known brain-teaser in statistics. It is loosely based on the game show Let's Make a Deal, which was hosted by the problem's namesake, Monty Hall. Here is how it works:
	
		An contestant is presented with 3 doors. One door has a brand new car and the other two have goats. After the contestant makes a choice, the host opens one of the doors containing a goat and asks the contestant if they would like to switch to the other unopened door. Would it be wiser to do so or does it even matter?
	
	It does, in fact, matter whether or not the contestant switches. If they stick with the door they initially picked, then there is a 33% chance they are correct and a ~67% chance that it is one of the other two doors. These percentages do NOT change once one of the other doors is opened, and if the contestant switches, they will be twice as likely to be correct. This is proved in my MontyHall program, which runs 10 million simulations where the contestant switches and 10 million where the contestant does not switch. After many, many trials, not once did the results deviate from at least 33.3% for switching and 66.7% for not switching.
