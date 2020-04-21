# 5 - Continuous Delivery

## Waterfall Development

### Waterfall Model Definition

Waterfall model has been defined by industry as a model of flow from one phase of software design and implementation to the other sequentially. The problem with this is that there isn't much scope of going back and reworking things after the phase ends.

### Cost of Change Curve

A usual software engineering project goes through the following phases:

- requirements
- design
- coding
- testing
- deployment
- release

As you go down the list, the cost of change becomes significantly bigger. Following waterfall model engineers spend a lot of time on analysis and requirements early in the project before writing any code, to try and make sure everything is right the first time. Unfortunately this rarely works.

This way of delivering a project is risky because:

- for the majority of project life, we are spending money, but not making any money back
- how will we know if the client is happy with the outcome in the end?
- what if we miss a deadline and don't deliver a workign system?

## Agile

### Agile definition

It is rare to find a waterfall project these days. Most industrial teams are using **agile**, iterative methods and to revise and refine the design of their software constantly as they add new features, fix bugs, etc. Authors of the agile manifesto acknowledge that having some sort of plan is good, but that to deliver the best and most valuable software, we should be happy to change that plan when we get new information.

Agile methods have the following things in common:

- work in short iterations (cycles)
- re-prioritise requirements to make sure to always work on what's important for the customer
- aim to deliver value from the first release (early on), start generating revenue earlier
- reduces time between someone having an idea and the implementation

### Agile Methods

1. **Extreme Programming (XP)** - works well for software projects. Method includes project management techniques and technical practices to be used to deliver reliable software quickly.
2. **Scrum** - concentrates more on project management methods, doesn't talk specifically about building software.
3. **Kanban** - more recent method in software circles. Gets rid of timeboxed iterations of XP and Scrum, but _aims for a continuous flow of work_.

## Continuous integration

We want to make the development cycles small, so that we can get feedback as early and as often as possible. But we don't want to sacrifice the engineering rigour that goes into making a reliable, well-tested product. To do this, we compress the analysis-code-test-release cycle (everyone weeks long) and perform it many times during the project.

Continuous integration is what agile teams use to move quickly and release often. This avoids the situation where each developer works on a separate branch of the code and only integrates the features into master once the features are completed (such long-lived branches can cause painful integration problems). Continuous integration says **each developer should merge all their work to master at least once per day**. So the developers work in small, non-breaking changes and keep master branch in a state where it could be deployed at any time. Typically automated build includes all the tests and checks before and after each push, which helps to keep the master branch in a healthy state.
