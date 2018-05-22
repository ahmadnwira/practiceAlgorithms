import unittest
import json
from rolldice import app


class RollDiceTestCase(unittest.TestCase):
    def test_roll_dice(self):
        tester = app.test_client(self)
        rv = tester.get('/dice')

        data = json.loads(rv.data)['result']

        # checks that returned values in the excpected range
        self.assertIn(data, range(1, 7))
        # checks that the response formated as expected
        self.assertEqual(
            str.encode('{"result": %s}' % data), rv.data
            )

if __name__ == '__main__':
    unittest.main()
