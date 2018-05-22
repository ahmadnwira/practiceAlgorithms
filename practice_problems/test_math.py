import unittest
from math import mult


class MultTestCase(unittest.TestCase):
    """Tests for math.py."""

    def test_4_5(self):
        self.assertEquals(mult(5, 4), 20)

    def test_this_will_fail(self):
        self.assertEquals(mult(4, 4), 8)
