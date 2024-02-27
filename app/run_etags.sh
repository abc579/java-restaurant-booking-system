#!/bin/bash

find . -name '*.java' -type f | xargs etags
