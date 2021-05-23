# ASMR Pattern Prototype
As an extension to the ASMR Processor Prototype,
this lib allows for pattern matching against the asm tree.

This is part of a future compiler library to help write compilers for transformers.

**Note that this library is not yet functional**

## Basic usage
In order to test the current usability of this pattern matching,
here are a few words of introduction.

To match any node in the tree, create a `NodePattern` like this:
```
NodePattern<Void, ClassNode> classPattern = new NodePattern<>(ClassNode.class);
```
This will create a pattern matching *any* `ClassNode`.

Note the heavy use of generics:
If you use IntelliJ or a similarly capable IDE,
you can use a raw type on the left-hand side initially
and let the IDE auto-complete it after you're written the right-hand side.

You can narrow down the matches by additionally matching parents or children:
```
ValuePattern<ClassNode, ClassNode.NameNode, String> classNamePattern =
    new ValuePattern<>(ClassNode.NameNode.class)
        .match(Matcher.exact("/pkg/ClassName"));
NodePattern<Void, ClassNode> classPattern = new NodePattern<>(ClassNode.class)
```
This will match *any* class with the name `/pkg/ClassName`.
(Which should usually only be  a single class.)

Note the heavy use of inner classes:
`ClassNode.NameNode` is different to `MethodNode.NameNode`.
However, they provide the exact same functionality (both extending `AbstractValueNode<String>`).

Check the tests for (a few) examples.