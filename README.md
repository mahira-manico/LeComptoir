<div align="center">

<img src="https://capsule-render.vercel.app/api?type=waving&color=ff8fb8&height=200&section=header&text=Le%20Comptoir&fontSize=64&fontColor=ffffff&animation=fadeIn&fontAlignY=38&desc=a%20checkout%20engine%20with%20style&descAlignY=58&descSize=20" alt="Le Comptoir banner" width="100%"/>

<img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=500&size=20&pause=1200&color=FF69B4&center=true&vCenter=true&width=520&lines=Pure+OOP+checkout+engine+%E2%9C%A8;Java+21+%2B+strict+TypeScript+%F0%9F%92%97;Strategy+%2B+Builder+patterns+%F0%9F%8C%B8" alt="Typing animation"/>

<br/>

![Java](https://img.shields.io/badge/Java-21-ff69b4?style=for-the-badge&logo=openjdk&logoColor=white)
![TypeScript](https://img.shields.io/badge/TypeScript-strict-f48fb1?style=for-the-badge&logo=typescript&logoColor=white)
![Patterns](https://img.shields.io/badge/Patterns-Strategy%20%2B%20Builder-ec407a?style=for-the-badge)

**Repository:** [`mahira-manico/LeComptoir`](https://github.com/mahira-manico/LeComptoir)

</div>

---

Le Comptoir is a checkout engine built with pure OOP in **Java 21**, plus an optional client demo written in **strict TypeScript**.

## 📑 Table of Contents

1. [Architecture & Design](#-architecture--design)
2. [Prerequisites](#-prerequisites)
3. [Get the Code](#-get-the-code)
4. [Build & Run](#-build--run)
5. [Documentation](#-documentation)
6. [Deliverables Checklist](#-deliverables-checklist)
7. [Contributors](#-contributors)

---

## 🌸 Architecture & Design

The project deliberately avoids any web framework in order to showcase object-oriented design:

- 🎀 **Strategy pattern:** dynamic computation and selection of the best discount (`DiscountStrategy`, `FidelityDiscount`, `FreeDrinkDiscount`, etc.).
- 🧾 **Builder pattern:** modular, decoupled construction of the receipt (`ReceiptBuilder`, `TextReceiptBuilder`, `ReceiptDirector`).
- 🔒 **Strict encapsulation:** internal state is protected (`Cart` is read-only from the outside, validation lives in the compact constructors of `record` types).

---

## 💻 Prerequisites

- **Java JDK 21**
---

## 📥 Get the Code

```bash
git clone https://github.com/mahira-manico/LeComptoir.git
cd LeComptoir
```

---

## 🚀 Build & Run

The Java source root is the `engine/` folder, and the code lives in `engine/src/`.

### Option A: Java engine only (quick tests via `Main`)

The TypeScript client is **not required**. You can test the engine directly:

1. Open the project in **IntelliJ IDEA** (project SDK set to JDK 21).
2. Build the project (`Build > Build Project`).
3. Run the `Main` class to execute the simple tests / demo scenarios and see the receipts printed in the console.

### Option B: Java server + TypeScript client

**1. Start the Java server (backend)**

Run the `LambdaServer` class (`engine/src/LambdaServer.java`) from IntelliJ.
The server listens on `http://localhost:8080/checkout`.

**2. Run the TypeScript demo**

From a terminal, go to the `demo/` folder and run:

```bash
cd demo
npx tsx index.ts
```

Alternative (compile first, then run):

```bash
npx tsc index.ts && node index.js
```

The demo sends an HTTP request to the Java server, which generates the receipt and prints it in its console right away.

---

## 📚 Documentation

All supporting documents are in the `docs/` folder:

- 🔍 Audit report on the partner's repository
- ✍️ Written response to the audit we received
- 📐 Before/after UML diagram for the refactoring Strategy

---

## ✅ Deliverables Checklist

| # | Deliverable | Requirement | Status |
|---|-------------|-------------|--------|
| 1 | Git tags `v1` to `v5` | Each tag placed on a working version of the 5 requests | ✅ Done |
| 2 | Java 21 engine + TS demo | Pure Java 21 and a TS script that sends the request | ✅ Done |
| 3 | Partner audit report | 3 pages max, `file:line` format, ending with the 6th request | ✅ Done (`docs/`) |
| 4 | Written response to the received audit | Point by point: fixed or contested with a technical argument | ✅ Done (`docs/`) |
| 5 | Refactored code + UML diagrams | At least 2 patterns (Strategy + Builder), before/after diagrams | ✅ Done (`docs/`) |
| 6 | 6th request implemented | On a dedicated branch, with Git tag `v6` | ✅ Done |
| 7 | `README.md` | Clear build and run instructions | ✅ Done |

---

## 💖 Contributors

<div align="center">

<table>
  <tr>
    <td align="center" width="160">
      <a href="https://github.com/mahira-manico">
        <img src="https://github.com/mahira-manico.png?size=120" width="100" alt="mahira-manico"/><br/>
        <sub><b>mahira-manico</b></sub>
      </a>
    </td>
    <td align="center" width="160">
      <a href="https://github.com/moinahalima-abdou">
        <img src="https://github.com/moinahalima-abdou.png?size=120" width="100" alt="moinahalima-abdou"/><br/>
        <sub><b>moinahalima-abdou</b></sub>
      </a>
    </td>
  </tr>
</table>

<br/>

<img src="https://capsule-render.vercel.app/api?type=waving&color=ff8fb8&height=100&section=footer" alt="footer" width="100%"/>

</div>