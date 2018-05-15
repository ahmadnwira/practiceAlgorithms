import json
import random

from flask import Flask
app = Flask(__name__)


@app.route('/')
def hello_world():
    return 'Hello World!'


@app.route('/dice')
def roll_dice():
    return json.dumps({'result': random.randint(1, 6)})

if __name__ == '__main__':
    app.debug = True
    app.run()
