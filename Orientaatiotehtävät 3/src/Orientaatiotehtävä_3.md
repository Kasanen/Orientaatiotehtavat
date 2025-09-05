# Orientaatiotehtävä 3
1. This is how I would make the program:
- I would define the age distribution. 
- Generate a random number between 1 and 100.
- Find which age corresponds to this random number.
- Store the age.
- Repeat the process 1000 times.

3. There are couple of reasons. Main reasons are:
- Constructor is private, so you can't call it outside the class.
- The class itself decides when and how the single object is created.
- Access goes trought getInstance(). It gives you same object and never the new one.

4. Here are few distributions that could be used in the simulator:
 
- Normal: Human height, exam scores, measurement errors
- Exponential: Time between bus arrivals, time until a phone call
- Poisson: Cars passing a toll booth per minute, number of emails per hour
- Uniform: Rolling fair die, random number between 1-100
- Triangular: Project duration estimates (min 2h, max 6h, most likely 4h)
- Bernoulli / Binomial: Coin flips, probability of machine working
- Weibull: Lifetimes of electronic components, time to failure