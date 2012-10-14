Grender
=============

Grender is a HTML component-based templating system written in Scala. It provides functionality to construct HTML using CSS selectors and modular components. It emphasizes separation of logic and markup. It is designed to be lightweight and readable.

Basic Example
-------------

###Logic: ListContacts.scala 
```scala
class ListContacts extends Renderer with Renderers with Body {
    val template = "contacts"
    val renderers = Seq(
      Select(".contacts tbody tr",
        Repeat(Contacts.list.map(contact =>
          Group(
            Select(".name", Value(contact.name)),
            Select(".address", Value(contact.address)),
            Select(".city", Value(contact.city)),
            Select(".state", Value(contact.state)),
            Select(".zip", Value(contact.zip)),
            Select(".action .view", SetAttribute("href", "/contacts/" + contact.id))
          )): _*)))
```

###Markup: contacts.xml
```html
<table class="contacts table">
  <thead>
      <tr>
          <th>Name</th>
          <th>Address</th>
          <th>City</th>
          <th>State</th>
          <th>Zip</th>
          <th>Action</th>
      </tr>
  </thead>
  <tbody>
      <tr>
          <td class="name"/>
          <td class="address"/>
          <td class="city"/>
          <td class="state"/>
          <td class="zip"/>
          <td class="action">
              <a class="view">View</a>
          </td>
      </tr>
  </tbody>
</table>
```

###Result: new ListContacts().rendered
```html
<table xmlns="http://www.w3.org/1999/xhtml" class="contacts table">
  <thead>
      <tr>
          <th>Name</th>
          <th>Address</th>
          <th>City</th>
          <th>State</th>
          <th>Zip</th>
          <th>Action</th>
      </tr>
  </thead>
  <tbody>
      <tr>
          <td class="name">Bobbye L. Hickey</td>
          <td class="address">3237 Heather By-pass</td>
          <td class="city">Radium</td>
          <td class="state">Wisconsin</td>
          <td class="zip">54862-9272</td>
          <td class="action">
              <a class="view" href="/contacts/3">View</a>
          </td>
      </tr>
      <tr>
          <td class="name">Beth J. King</td>
          <td class="address">2741 Middle Cape</td>
          <td class="city">Imalone</td>
          <td class="state">Illinois</td>
          <td class="zip">61094-5876</td>
          <td class="action">
              <a class="view" href="/contacts/1">View</a>
          </td>
      </tr>
      <tr>
          <td class="name">Alfred P. Martin</td>
          <td class="address">1715 Cozy Oak Maze</td>
          <td class="city">Lucky Valley</td>
          <td class="state">Louisiana</td>
          <td class="zip">71586-3329</td>
          <td class="action">
              <a class="view" href="/contacts/2">View</a>
          </td>
      </tr>
  </tbody>
</table>
```