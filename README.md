# marsrover

Three state machine:
* Charging
* Available
* Moving

It will be available on the set up of the application, when the charge is full or when it is stop of moving. 
Moving consume battery, if it reach 0 it will start to charge.

API
* battery/charge
* battery/stop
* /move/start (parameters X,Y as floats)
* /move/stop
