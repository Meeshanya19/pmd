---
title: Error Prone
summary: Rules to detect constructs that are either broken, extremely confusing or prone to runtime errors.
permalink: pmd_rules_swift_errorprone.html
folder: pmd/rules/swift
sidebaractiveurl: /pmd_rules_swift.html
editmepath: ../pmd-swift/src/main/resources/category/swift/errorprone.xml
keywords: Error Prone, ForceCast, ForceTry
language: Swift
---
<!-- DO NOT EDIT THIS FILE. This file is generated from file ../pmd-swift/src/main/resources/category/swift/errorprone.xml. -->
## ForceCast

**Since:** PMD 7.0

**Priority:** Medium (3)

Force casts should be avoided. This may lead to a crash if it's not used carefully.
For example assuming a JSON property has a given type, or your reused Cell has a certain contract.
Consider using conditional casting and handling the resulting optional.

**This rule is defined by the following XPath expression:**
``` xpath
//TypeCastingOperator[starts-with(@Text,'as!')]
```

**Example(s):**

``` swift
{%raw%}NSNumber() as! Int // violation, force casting

NSNumber() as? Int // no violation{%endraw%}
```

**Use this rule by referencing it:**
``` xml
<rule ref="category/swift/errorprone.xml/ForceCast" />
```

## ForceTry

**Since:** PMD 7.0

**Priority:** Medium (3)

Force tries should be avoided. If the code being wrapped happens to raise and exception, our application will crash.
Consider using a conditional try and handling the resulting optional, or wrapping the try statement in a do-catch block.

**This rule is defined by the following XPath expression:**
``` xpath
//TryOperator[@Text='try!']
```

**Example(s):**

``` swift
{%raw%}let x = try! someThrowingFunction() // violation, force trying

let x = try? someThrowingFunction() // no violation{%endraw%}
```

**Use this rule by referencing it:**
``` xml
<rule ref="category/swift/errorprone.xml/ForceTry" />
```
