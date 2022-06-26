### To Run the backend
```./gradlew bootRun```
The backend will start at http://localhost:8080

### To run the frontend
```npm install```
then ```ng serve```
The frontend will start at http://localhost:4200

The UI has two tabs ```Vending Machine``` and ```History```

In ```Vending Machine``` you can insert a quarter, remove a quarter,
and push for soda. The UI shows how many sodas are left and the state of 
the vending machine.

In ```History``` you can see a list of soda purchase history.

The backend implements a simple state machine to manage the state of the
vending machine.
